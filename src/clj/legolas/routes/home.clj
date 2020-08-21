(ns legolas.routes.home
  (:require
   [legolas.layout :as layout]
   [legolas.db.core :as db]
   [clojure.java.io :as io]
   [legolas.middleware :as middleware]
   [ring.util.response]
   [gandalf.core :as g]
   [gandalf.sql :as sql]
   [resources.resources :as resource]
   [ring.util.http-response :as response]))

(defn home-page [request]
  (layout/render request "home.html"))

(defn home-routes []
  (sql/set-datasource db/*db*)
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get home-page}]
   (g/create-routes resource/user-resource)
   ["/docs" {:get (fn [_]
                    (-> (response/ok (-> "docs/docs.md" io/resource slurp))
                        (response/header "Content-Type" "text/plain; charset=utf-8")))}]])

