Rational Option
===============

*A better option type for java.*

##About

Rational Option is an implementation of the [option type](http://en.wikipedia.org/wiki/Option_type) for Java. It's got a twist, however: when you return an Absent option, Rational allows you to include an Exception. The idea here is that when something fails, you can provide a programmatic "reason" for that failure, for better handling down the line. 

##More on Option Types

Option types are designed to promote more sane behavior for cases where a function can return no value sometimes, and some value others. This is certainly not the first implementation of Option types for Java: Google Guava provides the [Optional](http://code.google.com/p/guava-libraries/wiki/UsingAndAvoidingNullExplained) [class](http://docs.guava-libraries.googlecode.com/git-history/release/javadoc/com/google/common/base/Optional.html), which is fairly commonly used. Indeed, it is clear that option types in Java are very effective in reducing nullpointer exceptions and other common issues. 

