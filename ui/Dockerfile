FROM node:9
WORKDIR /src
COPY ./package.json /src/package.json
COPY ./package-lock.json /src/package-lock.json
RUN npm install --silent
ENV NODE_ENV development
EXPOSE 3000
CMD ["npm", "start"]