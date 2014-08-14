# README #

If you do any serious Android development, you've probably used [ProGuard](proguard.sourceforge.net/index.html) to obfuscate, optimise and shrink your application. In that case it's also very likely that ProGuarding your app has broken your release builds, took a few hours of your time away while pulling your hair out.

Squad leader will hopefully make this a little bit more easier. It includes two annotations that you can add to your code to specify that you want to `@Keep` a class, method or field and it's name. There's also a `@KeepName` annotation that does the same, but only if the annotated element is actually _used_ in your code. When in doubt, you'll probably want to use `@Keep`.

Additionally, through the magic of Android AAR libraries, this library contains [common recipes](https://bitbucket.org/littlerobots/squadleader/src/8d3f1add0d36595d179f19411a9df632b19f6e7e/squadleader/src/rules/) for libraries that are out there. When you add this library to your Gradle build, these configurations automatically get applied when ProGuarding your app, which means you need less configuration and less headaches.

### Using the library ###

Squad leader is available on Maven Central, so this should be easy. Just add a dependency to your Gradle build file like this:

```
#!groovy
dependencies {
    ...
    compile 'nl.littlerobots.squadleader:squadleader:<insert-latest-version>'
    ...
}
```

You can now annotate classes that you do not want to have touched by ProGuard just by annotating the appropriate class, field or method:


```
#!java

import nl.littlerobots.squadleader.Keep;
import nl.littlerobots.squadleader.KeepName;

public class Example {
    @KeepName
    // this field will be stripped if it's unused in your code
    public String stringTheory;
    @Keep
    // this field will be kept, even if it's unused
    public boolean myBool;
}
```

or

```
#!java
@Keep
// this class is not stripped or obfuscated
public class Example {
    public String stringTheory;
    public boolean myBool;
}
```

ProGuard rules for other libraries will be automatically applied when you run ProGuard as part of a release build.

### Contributing ###

You are very welcome to contribute additional rule files to this project. 

If you are a library author and you publish an `.aar`, there's no need to contribute here; you can include the ProGuard rules using the (undocumented?) `consumerProguardFiles` in your library. Consumers of your library will thank you :)

For libraries that are published as a jar contributions are welcome. When contributing please:

* Add a new rules file under `src/main/rules` and include _all_ ProGuard configuration needed for the library, even if some of that is already in other rules files. The ProGuard rules should be as specific as possible!
* Add the new rule file in `build.gradle` to the existing set of rules.
* If possible, extend the `verification` project so that you can verify that your rule works.
* Send a pull request with your changes, describing what it should do.

It's also OK to create an issue if the above is too challenging.

### Get in touch ###
Hit me up on [Google+](https://google.com/+hugovisser), [Twitter](https://twitter.com/botteaap) or through the contact page on the [Little Robots website](http://littlerobots.nl).

### Licence ###

```
This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or
distribute this software, either in source code form or as a compiled
binary, for any purpose, commercial or non-commercial, and by any
means.

In jurisdictions that recognize copyright laws, the author or authors
of this software dedicate any and all copyright interest in the
software to the public domain. We make this dedication for the benefit
of the public at large and to the detriment of our heirs and
successors. We intend this dedication to be an overt act of
relinquishment in perpetuity of all present and future rights to this
software under copyright law.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.

For more information, please refer to <http://unlicense.org/>
```