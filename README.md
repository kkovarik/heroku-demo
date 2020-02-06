# Heroku demo

https://devcenter.heroku.com/articles/getting-started-with-java
https://devcenter.heroku.com/articles/getting-started-with-nodejs
https://devcenter.heroku.com/articles/getting-started-with-go

Deployment options: git, github

Build process, buildpacks:
https://github.com/heroku/heroku-buildpack-java
https://elements.heroku.com/buildpacks/heroku/heroku-buildpack-nodejs

Heroku CLI:
https://devcenter.heroku.com/articles/heroku-cli#download-and-install

```
heroku git:remote -a kkovarik-demo
```

Push:
```
git push heroku master
```
- deployment from feature branches

Logs
```
heroku logs
```

Environment variables
```
heroku config:get INDEX_MESSAGE
heroku config:set INDEX_MESSAGE="Someone else"
```

Change java version
```
echo java.runtime.version=11 >> system.properties
```

Restart
```
heroku dyno:restart
```

Addons:


Other topics:
pipelines
deployment via Docker
