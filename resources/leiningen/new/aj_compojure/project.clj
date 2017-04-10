(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME"
  :url "http://FIXME"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.5.1"]
                 [ring/ring-defaults "0.2.3"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.5.2"]
                 [hiccup "1.0.5"]
                 [environ "1.1.0"]
                 [org.slf4j/slf4j-simple "1.7.25"]]
  :plugins [[lein-environ "1.1.0"]]
  :main {{namespace}}.core
  :env {:http-port "3000"}
  :repl-options {:init-ns user :init (start)}
  :profiles
  {:dev     {:source-paths ["dev"]
             :dependencies [[javax.servlet/servlet-api "2.5"]
                            [ring/ring-mock "0.3.0"]
                            [org.clojure/test.check "0.9.0"]
                            [im.chit/lucid.package "1.3.6"]]}
   :uberjar {:aot :all}})
