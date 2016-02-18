/*
 * Copyright Terracotta, Inc.
 *
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
package org.ehcache.spi.sizeof;

import org.ehcache.exceptions.LimitExceededException;
import org.ehcache.spi.cache.Store;

/**
 * SizeOf engines are used to calculate the size of objects.
 *
 * @author Abhilash
 *
 */
public interface SizeOfEngine {

  /**
   * Size of the objects on Heap including the
   * overhead
   *
   * @param key key to be sized
   * @param holder value holder to be sized
   * @return size of the objects on heap including the overhead
   * @throws LimitExceededException
   */
  <K, V> long sizeof(K key, Store.ValueHolder<V> holder) throws LimitExceededException;

}