(ns leiningen.new.aj-compojure
  (:require [leiningen.new.templates :refer [renderer year project-name
                                             sanitize-ns name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "aj-compojure"))

(defn aj-compojure
  "Create a new Compojure project with some deps"
  [name]
  (let [main-ns (sanitize-ns name)
        data    {:raw-name  name
                 :name      (project-name name)
                 :namespace main-ns
                 :dirs      (name-to-path main-ns)
                 :year      (year)}]
    (main/info "Generating fresh 'lein new' aj-compojure project.")
    (->files data
             [".gitignore" (render ".gitignore")]
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["src/{{dirs}}/handler.clj" (render "handler.clj" data)]
             ["src/{{dirs}}/view.clj" (render "view.clj" data)]
             ["src/{{dirs}}/core.clj" (render "core.clj" data)]
             ["test/{{dirs}}/handler_test.clj" (render "handler_test.clj" data)]
             ["dev/user.clj" (render "user.clj" data)]
             "resources/public")))
