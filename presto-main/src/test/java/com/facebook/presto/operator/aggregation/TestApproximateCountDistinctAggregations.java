/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.operator.aggregation;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.facebook.presto.operator.aggregation.ApproximateCountDistinctAggregations.standardErrorToBuckets;

public class TestApproximateCountDistinctAggregations
{
    @Test
    public void testStandardErrorToBuckets()
            throws Exception
    {
        Assert.assertEquals(standardErrorToBuckets(1), 2);
        Assert.assertEquals(standardErrorToBuckets(0.0326), 1024);
        Assert.assertEquals(standardErrorToBuckets(0.0325), 1024);
        Assert.assertEquals(standardErrorToBuckets(0.0324), 2048);
        Assert.assertEquals(standardErrorToBuckets(0.0231), 2048);
        Assert.assertEquals(standardErrorToBuckets(0.0230), 2048);
        Assert.assertEquals(standardErrorToBuckets(0.0229), 4096);
        Assert.assertEquals(standardErrorToBuckets(0.0164), 4096);
        Assert.assertEquals(standardErrorToBuckets(0.0163), 4096);
        Assert.assertEquals(standardErrorToBuckets(0.0162), 8192);
        Assert.assertEquals(standardErrorToBuckets(0.0116), 8192);
        Assert.assertEquals(standardErrorToBuckets(0.0115), 8192);
        Assert.assertEquals(standardErrorToBuckets(0.0114), 16384);
    }
}
