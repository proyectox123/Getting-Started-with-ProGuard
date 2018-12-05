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

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.igalata.bubblepicker.BubblePickerListener
import com.igalata.bubblepicker.adapter.BubblePickerAdapter
import com.igalata.bubblepicker.model.BubbleGradient
import com.igalata.bubblepicker.model.PickerItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    setupBubblePicker()
  }

  override fun onResume() {
    super.onResume()
    picker.onResume()
  }

  override fun onPause() {
    super.onPause()
    picker.onPause()
  }

  private fun setupBubblePicker() {
    picker.bubbleSize = 50
    picker.centerImmediately = true
    picker.adapter = object : BubblePickerAdapter {

      val colors = resources.obtainTypedArray(R.array.colors)
      val titles = listOf("1", "2", "3", "4", "5", "6")

      val multiplier = 2
      val modulus = 8
      val addition = 1

      override val totalCount = titles.size // 1

      override fun getItem(position: Int): PickerItem { // 2
        return PickerItem().apply {
          title = titles[position]

          val start = colors.getColor((position * multiplier) % modulus,0)
          val end = colors.getColor((position * multiplier) % modulus + addition,0)
          gradient = BubbleGradient(start, end, BubbleGradient.VERTICAL)

          textColor = ContextCompat.getColor(this@MainActivity, android.R.color.white)
        }
      }
    }

    picker.listener = object : BubblePickerListener { // 3

      override fun onBubbleSelected(item: PickerItem) {

      }

      override fun onBubbleDeselected(item: PickerItem) {

      }

    }
  }

  companion object {
    private const val SLOTH_KEY = "SLOTH"
  }
}
