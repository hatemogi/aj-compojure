(ns {{namespace}}.view
  (:require [hiccup.core :refer [h]]
            [hiccup.page :refer [html5 include-css include-js]]
            [ring.util.anti-forgery :refer [anti-forgery-field]]))

(defn- layout
  "HTML layout"
  [& content]
  (html5 [:head
          [:meta {:charset "utf-8"}]
          [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
          [:title "{{namespace}}"]
          (map include-css
               ["https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
                "https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"])]
         [:body content
          (map include-js ["https://code.jquery.com/jquery-3.2.0.min.js"
                           "https://unpkg.com/vue"])]))

(defn- wrap
  "main layout"
  [& content]
  (list [:nav [:ul.nav.nav-pills [:li [:a {:href "/"} [:i.fa.fa-home]]]]]
        [:main content]
        [:footer [:div.container "Footer here"]]))

(def #^{:private true :doc "page layout"}
  wrap-layout
  (comp layout wrap))

(defn index
  "first page"
  [req]
  (wrap-layout [:div.container
                [:div.row
                 "Ready to Rock"]]))
