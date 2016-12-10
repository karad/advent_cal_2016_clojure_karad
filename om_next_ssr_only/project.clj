(defproject om-tutorial "0.1.0-SNAPSHOT"
  :description "My first Om program!"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.51" :exclusions [org.apache.ant/ant]]

                 [org.omcljs/om "1.0.0-alpha47"]
                 [figwheel-sidecar "0.5.0-SNAPSHOT" :scope "test"]
                 [cljsjs/react-dom-server "15.2.1-1"]
                 [cljsjs/react "15.2.1-1"]
                 [cljsjs/react-dom "15.2.1-1"]
                 [sablono "0.7.4"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [hiccup "1.0.5"]
                 [com.ladderlife/cellophane "0.3.5"]
                 [arohner/foam "0.1.8"]
                 ]
  :plugins [[lein-ring "0.9.7"]
            [lein-figwheel "0.5.8"]
            [lein-cljsbuild "1.1.5"]]
  :ring {:handler om-tutorial.core/app}
  :cljsbuild {:builds {:dev {:figwheel     true
                             :source-paths ["src"]
                             :compiler     {
                                            :main       "om-tutorial.script"
                                            :asset-path "/js"
                                            :output-to  "resources/public/js/main.js"
                                            :output-dir "resources/public/js"
                                            :verbose    true}}}}
  :figwheel {}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
