FROM gcr.io/distroless/static
WORKDIR /app
COPY target/services /app/services
CMD ["/app/services"]