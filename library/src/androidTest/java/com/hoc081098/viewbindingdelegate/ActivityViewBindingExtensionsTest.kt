/*
 * MIT License
 *
 * Copyright (c) 2020-2021 Petrus Nguyễn Thái Học
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.hoc081098.viewbindingdelegate

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertSame
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.hoc081098.viewbindingdelegate.test.R as TestR

@RunWith(AndroidJUnit4::class)
public class ActivityViewBindingExtensionsTest {
  @get:Rule
  public val rule: ActivityScenarioRule<TestActivity> = activityScenarioRule()

  @Test
  public fun test_viewBindingReflection_viewsAreNotNull() {
    rule.scenario.onActivity { activity ->
      val bindingReflection = activity.bindingReflection

      assertNotNull(bindingReflection.root)
      assertNotNull(bindingReflection.textView)
      assertNotNull(bindingReflection.button)

      assertSame(activity.findViewById(TestR.id.textView), bindingReflection.textView)
      assertSame(activity.findViewById(TestR.id.button), bindingReflection.button)
    }
  }

  @Test
  public fun test_viewBindingWithoutReflection_viewsAreNotNull() {
    rule.scenario.onActivity { activity ->
      val binding = activity.binding

      assertNotNull(binding.root)
      assertNotNull(binding.textView)
      assertNotNull(binding.button)

      assertSame(activity.findViewById(TestR.id.textView), binding.textView)
      assertSame(activity.findViewById(TestR.id.button), binding.button)
    }
  }
}
