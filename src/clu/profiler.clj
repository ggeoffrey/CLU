(ns clu.profiler
  "Monitor functions, store data, decide if a function should be optimized.")


(def state (atom {}))


(defn get-handler
  "Generate a function that monitor the given function f."
  [f]
  ;; TODO
  )