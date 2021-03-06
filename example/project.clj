(defproject example "0.1.0-SNAPSHOT"
  :description "FIXME"
  :url "http://please.FIXME"
  :dependencies [[org.clojure/clojure       "1.8.0"]
                 [org.clojure/clojurescript "1.8.34"]
                 [org.clojure/core.async    "0.2.374"]
                 [io.nervous/cljs-lambda    "0.3.2"]]
  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-npm       "0.6.0"]
            [lein-doo       "0.1.7-SNAPSHOT"]
            [io.nervous/lein-cljs-lambda "0.6.0"]]
  :npm {:dependencies [[source-map-support "0.4.0"]]}
  :source-paths ["src"]
  :cljs-lambda
  {:env {:set     {"CLJS_LAMBDA_EXAMPLE" "Yes"}
         :capture #{"USER" #"^TEST_"}}
   :defaults      {:role "FIXME"}
   :resource-dirs ["static"]
   :functions
   [{:name   "work-magic"
     :invoke example.core/work-magic}]}
  :cljsbuild
  {:builds [{:id "example"
             :source-paths ["src"]
             :compiler {:output-to     "target/example/example.js"
                        :output-dir    "target/example"
                        :source-map    "target/example/example.js.map"
                        :target        :nodejs
                        :language-in   :ecmascript5
                        :optimizations :advanced}}
            {:id "example-test"
             :source-paths ["src" "test"]
             :compiler {:output-to     "target/example-test/example.js"
                        :output-dir    "target/example-test"
                        :target        :nodejs
                        :language-in   :ecmascript5
                        :optimizations :none
                        :main          example.test-runner}}]})
