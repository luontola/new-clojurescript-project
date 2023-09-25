(ns kata-test
  (:require [clojure.test :refer [deftest is testing]]
            [kata]))

(deftest dummy-test
  (testing "stuff"
    (is (= 3 (+ 1 2)))))
