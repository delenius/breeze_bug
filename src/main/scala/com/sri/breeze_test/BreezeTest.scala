package com.sri.breeze_test

import breeze.linalg._

object BreezeTest {

    val results: DenseMatrix[Int] = DenseMatrix.zeros[Int](10, 10)
    val sums: DenseVector[Int] = sum(results(::, *)).t
    sums(0)

}
