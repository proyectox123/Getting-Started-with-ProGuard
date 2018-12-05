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

import android.arch.lifecycle.ViewModel
import android.content.res.Resources
import org.simpleframework.xml.core.Persister
import java.util.SortedMap

class SlothViewModel : ViewModel() {

  private var sloths: SortedMap<String, Sloth>? = null

  fun getSloths(resources: Resources) : SortedMap<String, Sloth> {
    if (sloths == null) {
      loadSloths(resources)
    }

    return sloths ?: sortedMapOf()
  }

  private fun loadSloths(resources: Resources) { // 1
    val serializer = Persister()
    val inputStream = resources.openRawResource(R.raw.sloths) // 2
    val sloths = serializer.read(Sloths::class.java, inputStream) // 3
    sloths.list?.let { theList ->
      val map = theList.associateBy( { it.name }, {it})
      this.sloths = map.toSortedMap()
    }
  }
}