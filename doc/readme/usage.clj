(ns readme.usage
  (:require [clojure.tools.logging :as log]
            [strojure.slf4j-mdc.core :as mdc]))

(defn- update-user
  [user-id, data]
  (with-open [_ (mdc/put-closeable "user-id" (str user-id))
              _ (mdc/put-closeable "empty" nil)]
    (log/debug "Update user" data)))

(comment
  (update-user 100 {:name "Name"})
  ;; DEBUG readme.usage [ user-id=100 ]
  ;; - Update user {:name Name}

  (with-open [_ (mdc/put-closeable "request-id" "64024bf5-862a-4e9f-a827-b924fc04f6d8")]
    (update-user 100 {:name "Name"}))
  ;; DEBUG readme.usage [ request-id=64024bf5-862a-4e9f-a827-b924fc04f6d8, user-id=100 ]
  ;; - Update user {:name Name}
  )
