Rational Option
===============

*A better option type for java.*

##About

Rational Option is an implementation of the [option type](http://en.wikipedia.org/wiki/Option_type) for Java. It's got a twist, however: when you return an Absent option, Rational allows you to include an Exception. The idea here is that when something fails, you can provide a programmatic "reason" for that failure, for better handling down the line. 

##Option Types

Option types are designed to promote more sane behavior for cases where a function can return no value sometimes, and some value others. This is certainly not the first implementation of Option types for Java: Google Guava provides the [Optional](http://code.google.com/p/guava-libraries/wiki/UsingAndAvoidingNullExplained) [class](http://docs.guava-libraries.googlecode.com/git-history/release/javadoc/com/google/common/base/Optional.html), which is fairly commonly used. Indeed, it is clear that option types in Java are very effective in reducing nullpointer exceptions and other common issues. 

##Enhancing Option Types

In looking at the use cases for option types in Java, we find often find that they are used to encourage graceful error handling; where a function fails, instead of throwing an exception (messy) or returning a dangerous null, it's a bit cleaner to return an option which the caller can safely handle. The challenge with this is that most functions do not return None/Absent for no reason; often it's a failure of some underlying system. 

Rational Option provides an improvement upon this model: when a function returns an Absent, it can provide an Exception (which can be type-constrained generically) explaining its failure. This way, callers can handle failures programmatically (utilizing the Exception types and functionality) or even throw the exceptions up for catching/disruption. Additionally, this creates a clear declaration of what failures might result from the calling of a specific function (in the return type). 


