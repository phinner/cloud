//
// MIT License
//
// Copyright (c) 2024 Incendo
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.
//
package org.incendo.cloud.kotlin.extension

import org.checkerframework.common.returnsreceiver.qual.This
import org.incendo.cloud.exception.handling.ExceptionController
import org.incendo.cloud.exception.handling.ExceptionHandler
import org.incendo.cloud.exception.handling.ExceptionHandlerRegistration

/**
 * Decorates a registration builder using the given [decorator] and registers the result.
 *
 * The ordering matters when multiple handlers are registered tor the same exception type.
 * The last registered handler will get priority.
 *
 * @return [this] exception controller
 */
public inline fun <C, reified T : Throwable> @This ExceptionController<C>.register(
    decorator: ExceptionHandlerRegistration.BuilderDecorator<C, T>
): ExceptionController<C> = this.register(T::class.java, decorator)

/**
 * Registers the given [handler].
 *
 * The ordering matters when multiple handlers are registered tor the same exception type.
 * The last registered handler will get priority.
 *
 * @return [this] exception controller
 */
public inline fun <C, reified T : Throwable> @This ExceptionController<C>.registerHandler(
    handler: ExceptionHandler<C, T>
): ExceptionController<C> = this.registerHandler(T::class.java, handler)
