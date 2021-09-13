# breeze_bug

Reproduce a scalac bug triggered by the [breeze](https://github.com/scalanlp/breeze) library.

Just run `sbt compile`. This produces the errors below from scalac.

This appears to be the same as [this bug](https://github.com/scala/bug/issues/9578),
and the workaround listed there works.

```
scalac: Error: assertion failed: 
  List(method apply$mcI$sp, method apply$mcI$sp)
     while compiling: /Users/elenius/repos/caml/breeze_bug/src/main/scala/com/sri/breeze_test/BreezeTest.scala
        during phase: globalPhase=specialize, enteringPhase=explicitouter
     library version: version 2.13.6
    compiler version: version 2.13.6
  reconstructed args: -classpath /Users/elenius/repos/caml/breeze_bug/target/scala-2.13/classes:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/com/github/wendykierp/JTransforms/3.1/JTransforms-3.1.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/dev/ludovic/netlib/arpack/2.2.0/arpack-2.2.0.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/dev/ludovic/netlib/blas/2.2.0/blas-2.2.0.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/dev/ludovic/netlib/lapack/2.2.0/lapack-2.2.0.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/net/sf/opencsv/opencsv/2.3/opencsv-2.3.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/net/sourceforge/f2j/arpack_combined_all/0.1/arpack_combined_all-0.1.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/apache/commons/commons-math3/3.5/commons-math3-3.5.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/modules/scala-collection-compat_2.13/2.2.0/scala-collection-compat_2.13-2.2.0.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.6/scala-library-2.13.6.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-reflect/2.13.6/scala-reflect-2.13.6.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scalanlp/breeze-macros_2.13/2.0-RC3/breeze-macros_2.13-2.0-RC3.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scalanlp/breeze_2.13/2.0-RC3/breeze_2.13-2.0-RC3.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.5/slf4j-api-1.7.5.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/typelevel/algebra_2.13/2.0.1/algebra_2.13-2.0.1.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/typelevel/cats-kernel_2.13/2.1.1/cats-kernel_2.13-2.1.1.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/typelevel/spire-macros_2.13/0.17.0/spire-macros_2.13-0.17.0.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/typelevel/spire-platform_2.13/0.17.0/spire-platform_2.13-0.17.0.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/typelevel/spire-util_2.13/0.17.0/spire-util_2.13-0.17.0.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/typelevel/spire_2.13/0.17.0/spire_2.13-0.17.0.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/pl/edu/icm/JLargeArrays/1.5/JLargeArrays-1.5.jar

  last tree to typer: Select(Select(Select(Ident(breeze), linalg), DenseMatrix), zeros$mIc$sp)
       tree position: line 7 of /Users/elenius/repos/caml/breeze_bug/src/main/scala/com/sri/breeze_test/BreezeTest.scala
            tree tpe: (rows: Int, cols: Int, evidence$1: scala.reflect.ClassTag[Int], evidence$2: breeze.storage.Zero[Int]): breeze.linalg.DenseMatrix[Int]
              symbol: method zeros$mIc$sp in object DenseMatrix
   symbol definition: def zeros$mIc$sp(rows: Int, cols: Int, implicit evidence$1: scala.reflect.ClassTag[Int], implicit evidence$2: breeze.storage.Zero[Int]): breeze.linalg.DenseMatrix[Int] (a MethodSymbol)
      symbol package: breeze.linalg
       symbol owners: method zeros$mIc$sp -> object DenseMatrix
           call site: value sums in object BreezeTest in package breeze_test

== Source file context for tree position ==

     4 
     5 object BreezeTest {
     6 
     7     val results: DenseMatrix[Int] = DenseMatrix.zeros[Int](10, 10)
     8     val sums: DenseVector[Int] = sum(results(::, *)).t
     9     sums(0)
    10 
java.lang.AssertionError: assertion failed: 
  List(method apply$mcI$sp, method apply$mcI$sp)
     while compiling: /Users/elenius/repos/caml/breeze_bug/src/main/scala/com/sri/breeze_test/BreezeTest.scala
        during phase: globalPhase=specialize, enteringPhase=explicitouter
     library version: version 2.13.6
    compiler version: version 2.13.6
  reconstructed args: -classpath /Users/elenius/repos/caml/breeze_bug/target/scala-2.13/classes:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/com/github/wendykierp/JTransforms/3.1/JTransforms-3.1.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/dev/ludovic/netlib/arpack/2.2.0/arpack-2.2.0.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/dev/ludovic/netlib/blas/2.2.0/blas-2.2.0.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/dev/ludovic/netlib/lapack/2.2.0/lapack-2.2.0.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/net/sf/opencsv/opencsv/2.3/opencsv-2.3.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/net/sourceforge/f2j/arpack_combined_all/0.1/arpack_combined_all-0.1.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/apache/commons/commons-math3/3.5/commons-math3-3.5.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/modules/scala-collection-compat_2.13/2.2.0/scala-collection-compat_2.13-2.2.0.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.6/scala-library-2.13.6.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-reflect/2.13.6/scala-reflect-2.13.6.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scalanlp/breeze-macros_2.13/2.0-RC3/breeze-macros_2.13-2.0-RC3.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scalanlp/breeze_2.13/2.0-RC3/breeze_2.13-2.0-RC3.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.5/slf4j-api-1.7.5.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/typelevel/algebra_2.13/2.0.1/algebra_2.13-2.0.1.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/typelevel/cats-kernel_2.13/2.1.1/cats-kernel_2.13-2.1.1.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/typelevel/spire-macros_2.13/0.17.0/spire-macros_2.13-0.17.0.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/typelevel/spire-platform_2.13/0.17.0/spire-platform_2.13-0.17.0.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/typelevel/spire-util_2.13/0.17.0/spire-util_2.13-0.17.0.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/typelevel/spire_2.13/0.17.0/spire_2.13-0.17.0.jar:/Users/elenius/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/pl/edu/icm/JLargeArrays/1.5/JLargeArrays-1.5.jar
```
