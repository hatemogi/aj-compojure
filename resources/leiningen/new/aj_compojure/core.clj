(ns {{namespace}}.core
  (:gen-class)
  (:require [{{namespace}}.handler]
            [ring.adapter.jetty :as jetty]
            [environ.core :refer [env]]))

(def ^:private env-int (comp #(Integer/valueOf %) env))

(defn- reloadable
  "handler for development"
  [req]
  ((deref #'{{namespace}}.handler/app) req))

(defonce state (atom {}))

(defn stop []
  (if-let [http-server (:http-server @state)]
    (.stop http-server)))

(defn start [opts]
  (stop)
  (if-let [server (jetty/run-jetty (if (:reloadable? opts)
                                     reloadable
                                     {{namespace}}.handler/app)
                                   {:join? false
                                    :port  (env-int :http-port)})]
    (swap! state (fn [s] (assoc s :http-server server)))))

(defn -main
  "start application"
  []
  (start {}))
