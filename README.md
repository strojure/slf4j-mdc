# slf4j-mdc

Clojure utility for SLF4J logging system's MDC (Mapped Diagnostic Context).

[![Clojars Project](https://img.shields.io/clojars/v/com.github.strojure/slf4j-mdc.svg)](https://clojars.org/com.github.strojure/slf4j-mdc)

## Design goals

* Helper functionality to work with MDC.

## Usage

```clojure
(ns user.readme-usage
  (:require [clojure.tools.logging :as log]
            [strojure.slf4j-mdc.core :as mdc]))

(defn- update-user
  [user-id, data]
  (with-open [_ (mdc/put-closeable "user-id" (str user-id))
              _ (mdc/put-closeable "empty" nil)]
    (log/debug "Update user" data)))

(comment
  (update-user 100 {:name "Name"})
  ;16:17:27.730 DEBUG [9a5-bd15-8869f2b0fbda]  user.readme-usage  user-id=100
  ; - Update user {:name Name}
  
  (with-open [_ (mdc/put-closeable "request-id" "64024bf5-862a-4e9f-a827-b924fc04f6d8")]
    (update-user 100 {:name "Name"}))
  ;16:22:10.431 DEBUG [9a5-bd15-8869f2b0fbda]  user.readme-usage  request-id=64024bf5-862a-4e9f-a827-b924fc04f6d8, user-id=100
  ; - Update user {:name Name}
  )
```
