FROM python:3.7-slim
MAINTAINER Andy Duss github@mindovermiles262

RUN apt-get update && apt-get install -y build-essential

COPY . /build
RUN pip install -r /build/requirements.txt

WORKDIR /test
CMD "make test"
