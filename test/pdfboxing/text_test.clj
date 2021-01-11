(ns pdfboxing.text-test
  (:require [clojure.test :refer [deftest is]]
            [pdfboxing.text :refer [extract extract-by-areas]]))

(def line-separator (System/getProperty "line.separator"))

(deftest text-extraction
  (is (= (str "Hello, this is pdfboxing.text" line-separator)
         (extract "test/pdfs/hello.pdf"))))

(deftest text-extract-by-areas
  (let [areas [{:x           150
                :y           100
                :w           260
                :h           40
                :page-number 0}
               {:x           380
                :y           500
                :w           27
                :h           23
                :page-number 4}]]
    (is (= ["Clojure 1.6 Cheat Sheet (v21)\n"
            "*ns*\n"]
           (extract-by-areas "test/pdfs/multi-page.pdf" areas)))))
