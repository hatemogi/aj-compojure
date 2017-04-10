(ns {{namespace}}.handler-test
  (:require [{{namespace}}.handler :refer :all]
            [clojure.test :refer :all]
            [clojure.test.check :as tc]
            [ring.mock.request :as mock]))

(deftest handler-test
  (let [res (app (mock/request :get "/"))]
    (is (= 200 (:status res)))
    (is (.contains (:body res) "Ready to Rock"))))
