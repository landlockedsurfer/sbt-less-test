# sbt-less-test

Quick demo `sbt` project to demonstrate an issue with `sbt-less` and the usage of less variables.
I could not fix the original issue, but found this workaround shown below. 

Start `sbt` and run
```
$ sbt
[info] Loading global plugins from /Users/landlockedsurfer/.sbt/1.0/plugins
[info] Loading settings for project sbt-less-example-build from plugins.sbt ...
[info] Loading project definition from /Users/landlockedsurfer/src/trash/sbt-less-example/project
[info] Loading settings for project LessTestProject from build.sbt ...
[info] Set current project to LessTestProject (in build file:/Users/landlockedsurfer/src/trash/sbt-less-example/)
[warn] sbt server could not start because there's another instance of sbt running on this build.
[warn] Running multiple instances is unsupported
[LessTestProject] $ less
[info] LESS compiling on 1 source(s)
[error] internal/fs/utils.js:701
[error]     throw new ERR_INVALID_ARG_TYPE(
[error]     ^
[error] 
[error] TypeError [ERR_INVALID_ARG_TYPE]: The "data" argument must be of type string or an instance of Buffer, TypedArray, or DataView. Received undefined
[error]     at Object.writeFile (fs.js:1385:5)
[error]     at /Users/landlockedsurfer/src/trash/sbt-less-example/project/target/less/lessc.js:89:20
[error]     at /Users/landlockedsurfer/src/trash/sbt-less-example/project/target/node-modules/webjars/mkdirp/index.js:47:26
[error]     at FSReqCallback.oncomplete (fs.js:177:5) {
[error]   code: 'ERR_INVALID_ARG_TYPE'
[error] }
[error] stack trace is suppressed; run last Web-assets / less for the full output
[error] (Web-assets / less) com.typesafe.sbt.jse.SbtJsTask$JsTaskFailure: internal/fs/utils.js:701
[error]     throw new ERR_INVALID_ARG_TYPE(
[error]     ^
[error] 
[error] TypeError [ERR_INVALID_ARG_TYPE]: The "data" argument must be of type string or an instance of Buffer, TypedArray, or DataView. Received undefined
[error]     at Object.writeFile (fs.js:1385:5)
[error]     at /Users/landlockedsurfer/src/trash/sbt-less-example/project/target/less/lessc.js:89:20
[error]     at /Users/landlockedsurfer/src/trash/sbt-less-example/project/target/node-modules/webjars/mkdirp/index.js:47:26
[error]     at FSReqCallback.oncomplete (fs.js:177:5) {
[error]   code: 'ERR_INVALID_ARG_TYPE'
[error] }
[error] Total time: 1 s, completed 6 Aug 2020, 12:12:37
[LessTestProject] $ 
```

to work around the problem change the file `app/assets/less/main.less` from

```
// /* add multiline comment to make things work, i.e. remove double slash at the start of this line */
// The problem seems to occur whenever the file starts with a variable declaration
@white: #fff;
```

```
/* add multiline comment to make things work, i.e. remove double slash at the start of this line */
// The problem seems to occur whenever the file starts with a variable declaration
@white: #fff;
```

