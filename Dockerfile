FROM ghcr.io/graalvm/native-image-community:17-ol8 AS builder

# Gradle required
RUN microdnf update \
  && microdnf install findutils \
  && microdnf clean all \
  && rm -rf /var/cache/yum

ADD . /build
WORKDIR /build

# COPY . .

RUN ./gradlew nativeCompile

# Second stage: ubuntu jammy image
FROM ubuntu:jammy

WORKDIR /app

# Copy the native binary from the build stage
COPY --from=builder /build/build/native/nativeCompile/graal-vm /app/spring-native

EXPOSE 8080

# Run the application
CMD ["/app/spring-native"]
