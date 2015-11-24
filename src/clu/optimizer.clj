(ns clu.optimizer
  "Everything about genetic programming"
  (:require [cljs.core.async :refer [go >! chan]]))


(defn optimize
  "Optimize a function f, return a channel or use a given channel.
  If a better function is found, it will be published to the chanel.
  Stucture is  {:success true|false
  				:function f|nil }"
	([f]
  		(optimize f (chan)))
    ([f chan]
     ;; TODO
     ))
