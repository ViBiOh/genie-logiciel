FROM scratch
MAINTAINER Vincent Boutour <vincent.boutour@gmail.com>

EXPOSE 1080
ENTRYPOINT [ "/server" ]

COPY server /
COPY web/ /
COPY doc/ /doc/
