(ns {{namespace}}.handler
    (:require [compojure.core :refer :all]
              [compojure.route :as route]
              [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
              [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
              [{{namespace}}.view :as v]))

(defroutes app-routes
  (GET "/" [] v/index)
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      wrap-json-response
      (wrap-json-body {:keywords? true})
      (wrap-defaults site-defaults)))
