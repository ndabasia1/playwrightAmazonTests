FROM mcr.microsoft.com/playwright/java:v1.27.1-focal

RUN mkdir /docker
WORKDIR /docker
CMD ["mvn", "test", "-Dgroups=mobilePhones"]