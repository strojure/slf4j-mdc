(ns strojure.slf4j-mdc.core
  "MDC logging context utility."
  (:import (java.io Closeable)
           (org.slf4j MDC)))

(set! *warn-on-reflection* true)

;;••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••

(def ^:private noop-closeable
  (reify Closeable (close [_])))

;;••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••

(defn put-closeable
  "Puts a diagnostic context value `v` as identified with the key `k` into the
  current thread's diagnostic context map. Returns a `Closeable` object who can
  remove key when close is called. The string `k` cannot be null. The `v` should
  be string or null. If the `v` is null then nothing is put and noop `Closeable`
  returned."
  ^Closeable
  [k v]
  (if (some? v) (MDC/putCloseable k v), noop-closeable))

;;••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••
