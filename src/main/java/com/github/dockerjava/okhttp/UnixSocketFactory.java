package com.github.dockerjava.okhttp;

import okhttp3.Dns;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import javax.net.SocketFactory;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;

public class UnixSocketFactory extends SocketFactory implements Dns {

    private final String socketPath;

    public UnixSocketFactory(String socketPath) {
        this.socketPath = socketPath;
    }

    @NotNull
    @Override
    public List<InetAddress> lookup(@NotNull String s) throws UnknownHostException {
        if (s.endsWith(".socket")) {
            return Collections.singletonList(InetAddress.getByAddress(s, new byte[]{0, 0, 0, 0}));
        } else {
            return Dns.SYSTEM.lookup(s);
        }
    }

    @Override
    public Socket createSocket() {
        try {
            return new UnixDomainSocket(socketPath) {
                @Override
                public void connect(SocketAddress endpoint, int timeout) throws IOException {
                    super.connect(endpoint, timeout);
                }

                @Override
                public InputStream getInputStream() {
                    return new FilterInputStream(super.getInputStream()) {
                        @Override
                        public void close() throws IOException {
                            shutdownInput();
                        }

                        @Override
                        public int read(byte[] b, int off, int len) throws IOException {
                            return super.read(b, off, len);
                        }
                    };
                }

                @Override
                public OutputStream getOutputStream() {
                    return new FilterOutputStream(super.getOutputStream()) {

                        @Override
                        public void write(byte[] b, int off, int len) throws IOException {
                            out.write(b, off, len);
                        }

                        @Override
                        public void close() throws IOException {
                            shutdownOutput();
                        }
                    };
                }
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Socket createSocket(String s, int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Socket createSocket(String s, int i, InetAddress inetAddress, int i1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Socket createSocket(InetAddress inetAddress, int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress1, int i1) {
        throw new UnsupportedOperationException();
    }
}
