FROM python:3.7-alpine
MAINTAINER Andy Duss github@mindovermiles262

RUN apk update && apk add git g++ make

COPY . /build
RUN pip install -r /build/requirements.txt

WORKDIR /test
CMD "make test"
