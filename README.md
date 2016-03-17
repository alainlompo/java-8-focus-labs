# java-8-focus-labs

<h3> exploring java 8 core enhancements </h3>
<br/>
The following aspects of java 8 enhancements are covered in the examples of the project
<br/>
<br/>
<ul>
  <li>The use of default keyword in interfaces to implements method bodies that an implementing class
  may choose not to implement. One important aspect of it is providing forward (and not backward) compatibility of legacy code with java 8</li>
  <li>The use of the <b>::</b> operator in filtering arrays and collections datas </li>
  <li>The use of lambdas expressions in various cases (such as sorting an array with <i>Arrays.sort</i> method</li>
  <li>the use of generic predicates as function value parameters allowing a value reference to boolean functions</li>
  <li>the use of the java 8 Stream object along with its filter and collect method</li>
  <li>Aggregating filtered datas from a stream with the use of <b>Collectors.groupingBy</b> method</li>
</ul>
<br/>
<p>
<h3>Backlog</h3>
<hr/>
<br/>
<ul>
<li>Using ParrallelStream</li>
<li>Using Optional to reduce NullPointerExceptions</li>
<li>Using pattern matching</li>
<li>Passing code with behaviour parameterization (Done!!!)</li>
<li>
    <span>
      Deep diving into lambda expressions
      <br/>
      <hr/>
      <ul>
         <li>Deep diving into functional interfaces (Done!!!)</li>
         <li>An early look at the execute around pattern (Done!!!)</li>
         <li>More functional interfaces (Done!!!)</li>
         <hr/>
         <ul>
            <li>Consumer interface</li>
            <li>Function interface</li>
            <li>Predicate interface</li>
         </ul>
         <br/>
         <li>Type checking (see an illustration <a href='https://github.com/alainlompo/java-8-focus-labs/blob/master/doc/lambda_type_checking.png'>here</a>)(Done!!!)</li>
         <li>Type inference(Done!!!)</li>
         <li>Method refrence(Done!!!)</li>
         <li>Constructor refrence (some examples using BiFunction and BePredicate) (Done!!!)</li>
      </ul>
      
    </span>
</li>
<li>Deep diving into streams</li>
<li>Deep diving into parrallel data processing and the performance impact</li>
<li>more soon...</li>
</ul>
</p>
<p>
  <h3>Direct access by topics</h3><br/>
  <ul>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/interfaces/defaultmethods'>Java 8 interfaces and default methods</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas'>Core lambda concepts illustrations</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/utils'>Taking advantage of Optional type</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/streams'>Core streams concepts</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/streams/collecting'>Custom usage of collect method (without implementing the Collector interface)</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/streams/filtering'>Streams based filtering technics</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/streams/grouping'>Grouping technics</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/streams/joining'>Joining demo</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/streams/matching'>Matching examples</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/streams/parallel'>Parallel stream, spliterator, forkjoin</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/streams/primitives'>Primitive streams, range and rangeClosed</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/streams/reducing'>Mapping and reducing</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/streams/summarization>Stats: summing, averaging, summarizing...</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/refactoring'>Refactoring classic code and design patterns</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/optional'>Using Optional types in a stream fashion</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/methodreference'>Usage of method reference</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/fi'>Various illustrations of functional interfaces usage</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/constructorreference'>Illustrating constructor reference</a></li>
    <li><a href='https://github.com/alainlompo/java-8-focus-labs/tree/master/java8-labs-home/java8-lambdas/src/main/java/org/lompo/labs/java8/lambdas/asynchronously'>Asynchronous streaming</a></li>
  </ul>
</p>
<p>
  <h3>Retro - lambda</h3>
  <br/>
  Esko Luontola build a great tool he called retrolambda. It allows you to compile your java 8 sources to a java 1.7 jvm and even older versions. This is great because a lot of customers won't migrate so easily to java 8: I am particularly thinking about banks, insurance companies, etc. Thanks to retro lambda you can still use the amazing features of java 8 such as lambda and delivers an app that runs on java 1.7 or 1.6. You can find more about retrolambda <a href='https://github.com/orfjackal/retrolambda'>here</a>
</p>
