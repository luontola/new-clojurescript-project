(defproject new-clojurescript-project "0.1.0-SNAPSHOT"

  :dependencies [[lambdaisland/fetch "1.5.83"]
                 [medley "1.4.0"]
                 [mhuebert/kitchen-async "0.1.0"]
                 [reagent "1.2.0"]
                 [reagent-utils "0.3.8"]
                 [thheller/shadow-cljs "2.25.6"]
                 ;; The following dependency versions must be in sync with Shadow CLJS.
                 ;; See the dependency versions at https://clojars.org/thheller/shadow-cljs
                 [com.google.javascript/closure-compiler-unshaded "v20230411" :upgrade false]
                 [org.clojure/clojure "1.11.1" :upgrade false]
                 [org.clojure/clojurescript "1.11.60" :upgrade false]]
  ;; Set explict versions for transient dependencies which produce warnings about possibly confusing dependencies.
  :managed-dependencies [[org.clojure/core.async "1.6.681"]
                         [io.methvin/directory-watcher "0.18.0"]
                         [org.clojure/tools.cli "1.0.219"]]
  :pedantic? :warn
  :global-vars {*warn-on-reflection* true}

  :main ^:skip-aot kata
  :target-path "target/%s"
  :javac-options ["--release" "17"]
  :jvm-opts ["-XX:-OmitStackTraceInFastThrow"]

  :aliases {"kaocha" ["with-profile" "+kaocha" "run" "-m" "kaocha.runner"]}
  :plugins [[lein-ancient "0.7.0"]]

  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[lambdaisland/kaocha "1.86.1355"]
                                  [nrepl "1.0.0"]
                                  [org.clojure/test.check "1.1.1"]]}
             :kaocha {}
             :cljs {:global-vars {*warn-on-reflection* false}}})
