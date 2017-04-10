(ns user
  (:require [{{namespace}}.core :refer [stop]]
            [lucid.package :refer [pull]]))

(defn start []
  ({{namespace}}.core/start {:reloadable? true}))
