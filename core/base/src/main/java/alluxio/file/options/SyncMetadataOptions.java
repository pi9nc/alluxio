/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.file.options;

import com.google.common.base.Objects;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * Method options for syncing the metadata of a path.
 *
 * @param <T> the type of the concrete subclass
 */
@NotThreadSafe
public abstract class SyncMetadataOptions<T extends SyncMetadataOptions> {
  protected CommonOptions mCommonOptions;

  /**
   * @return the common options
   */
  public CommonOptions getCommonOptions() {
    return mCommonOptions;
  }

  /**
   * @param options the common options
   * @return the updated options object
   */
  public T setCommonOptions(CommonOptions options) {
    mCommonOptions = options;
    return (T) this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SyncMetadataOptions)) {
      return false;
    }
    SyncMetadataOptions that = (SyncMetadataOptions) o;
    return Objects.equal(mCommonOptions, that.mCommonOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(mCommonOptions);
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this)
        .add("commonOptions", mCommonOptions)
        .toString();
  }
}