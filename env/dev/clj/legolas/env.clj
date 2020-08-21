(ns legolas.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [legolas.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[legolas started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[legolas has shut down successfully]=-"))
   :middleware wrap-dev})
