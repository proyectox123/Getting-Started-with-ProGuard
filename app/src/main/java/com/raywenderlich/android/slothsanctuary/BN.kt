/*
 * Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.slothsanctuary

import android.support.annotation.Keep
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties

class BN { //BubbleNumbers
  fun sn() { //setupNumbers

    //setValue
    sv("com.raywenderlich.android.slothsanctuary.GO", "f1", 2)
    sv("com.raywenderlich.android.slothsanctuary.GO", "f2", 8)
    sv("com.raywenderlich.android.slothsanctuary.GO", "f3", 1)
  }
}

@Keep
object GO { //GradientObject
  var f1 = 3 //field1
  var f2 = 6 //field2
  var f3 = 7 //field3
}

fun sv(ownerClassName: String, fieldName: String, value: Any) { //setValue - uses reflection
  val kClass = Class.forName(ownerClassName).kotlin // 1
  val instance = kClass.objectInstance ?: kClass.java.newInstance() // 2
  val member = kClass.memberProperties.filterIsInstance<KMutableProperty<*>>()
          .firstOrNull { it.name == fieldName } // 3
  member?.setter?.call(instance, value) // 4
}

