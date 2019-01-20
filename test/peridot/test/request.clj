(ns peridot.test.request
  (:require [clojure.test :refer :all]
            [peridot.request :refer [url]]
            [ring.mock.request :as mock]))

(deftest url-generation
  (testing "it should construct a URI from a ring reqeust"
    (is (= "http://example.com:4000/fuzbats"
           (url (mock/request :get "http://example.com:4000/fuzbats")))))
  (testing "it should include querystrings"
    (is (= "http://example.com:4000/fuzbats?a=1"
           (url (mock/request :get "http://example.com:4000/fuzbats?a=1"))))))
