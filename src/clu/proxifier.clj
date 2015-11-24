(ns clu.proxifier
  "Inject functions into user namespaces to intercept calls and reroute them to the profiler.")



(defn- make-interceptor
  "create an interceptor for given function as a symbol"
  [fn-to-intercept inteceptor]
  ;; TODO generate a function with the same name that redirect to the interceptor
  )


(defn- get-namespace
  "Give the namespace of a function as a symbol"
  [f]
  ;; todo return namespace
  )



;; TODO not ready yet
(defmacro inject-in-ns
  "Inject a fuction in a namespace"
  [namespace name function]
  `(binding [*ns* ~namespace]
     (def ~name ~function)))



(defn proxify! 
  "Redirect all calls of the given function to CLU. Will alter YOUR namespace"
  [f handler]
  (let [name (get-name f)
        namespace (get-namespace f)
        interceptor (make-interceptor f handler)]
    (inject-in-ns namespace name interceptor)))



