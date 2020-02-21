/**
 * Copyright (C) 2020 Orbeon, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 *  2.1 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * The full text of the license is available at http://www.gnu.org/copyleft/lesser.html
 */
package org.orbeon.xforms

import scala.util.control.NonFatal


// Minimal implementation of a callback list
class CallbackList[T] {

  private var fns: List[T => Unit] = Nil

  def add(fn: T => Unit): Unit =
    fns ::= fn

  def remove(fn: T => Unit): Unit =
    fns = fns filterNot (_ eq fn)

  def fire(v: T): Unit =
    fns foreach { fn =>
      try {
        fn(v)
      } catch {
        case NonFatal(t) =>
          scribe.debug(t)
      }
    }
}