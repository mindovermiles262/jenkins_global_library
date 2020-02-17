FROM python:3.7-slim
MAINTAINER Andy Duss github@mindovermiles262

COPY . /build
RUN pip install -r /build/requirements.txt

WORKDIR /test
CMD "make test"
