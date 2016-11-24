scala-cloudwatch-metrics
=======

A wrapper for sending Cloudwatch metrics in Scala. The intention is to make it easier to send CloudWatch metrics and allow batching of metrics for sending to cloudwatch to reduce cost and latency

This work is extracted from the [Grid Project](https://github.com/guardian/grid).

Installation
------------

**This library is currently a work in progress and may not currently be available.**

```scala
libraryDependencies ++= Seq(
  "com.gu" %% "scala-cloudwatch-metrics" % "0.0.1"
)
```

scala-cloudwatch-metrics is published for Scala 2.11

Usage
-------

```scala
// Set up your metrics
import com.amazonaws.auth.AWSCredentials
import com.gu.cloudwatch.metrics.CloudWatchMetrics


class AppMetrics(stage: String, creds: AWSCredentials)  
  extends CloudWatchMetrics(stage, creds) {

  val barCounter = new CountMetric("Bar")
  val fooTimer = new TimeMetric("Foo") 

} 

// Put data to metrics
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import com.gu.cloudwatch.metrics.FutureSyntax._


class AppMetricsExamples(appMetrics: AppMetrics) {
  def countExample {
    Future {
      // Do something
    }.incrementOnFailure(appMetrics.barCounter) { case _ => true }
  }

  def timerExample {
    val latency = 1 // The latency in milliseconds of some operation
    val dimensions = List(new Dimension().withName("name").withValue("value"))

    appMetrics.fooTimer.runRecordOne(latency, dimensions)
  } 
}

```
License
-------

scala-cloudwatch-metrics is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0) (the "License"); 
you may not use this software except in compliance with the License.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an 
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific 
language governing permissions and limitations under the License.
