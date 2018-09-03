/*
 * Copyright 2016 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.channel;

public interface ChannelInboundInvoker {

    /**
     * A {@link Channel} was registered to its {@link EventLoop}.
     *
     * This will result in having the  {@link ChannelInboundHandler#channelRegistered(ChannelHandlerContext)} method
     * called of the next  {@link ChannelInboundHandler} contained in the  {@link ChannelPipeline} of the
     * {@link Channel}.
     *
     * 一个通道注册到它的EventLoop。
     * 这将导致在Channel的ChannelPipeline中包含的下一个ChannelInboundHandler的channelRegistered (ChannelHandlerContext)方法被调用。
     *
     */
    ChannelInboundInvoker fireChannelRegistered();

    /**
     * A {@link Channel} was unregistered from its {@link EventLoop}.
     *
     * This will result in having the  {@link ChannelInboundHandler#channelUnregistered(ChannelHandlerContext)} method
     * called of the next  {@link ChannelInboundHandler} contained in the  {@link ChannelPipeline} of the
     * {@link Channel}.
     * 从EventLoop取消注册一个通道。
     * 这将导致在Channel的ChannelPipeline中包含的下一个ChannelInboundHandler的channelUnregistered(ChannelHandlerContext)方法被调用。
     */
    ChannelInboundInvoker fireChannelUnregistered();

    /**
     * A {@link Channel} is active now, which means it is connected.
     *
     * This will result in having the  {@link ChannelInboundHandler#channelActive(ChannelHandlerContext)} method
     * called of the next  {@link ChannelInboundHandler} contained in the  {@link ChannelPipeline} of the
     * {@link Channel}.
     * 一个通道现在是活动的，这意味着它是连接的。
     * 这将导致在Channel的ChannelPipeline中包含的下一个ChannelInboundHandler的channelActive(ChannelHandlerContext)方法被调用。
     */
    ChannelInboundInvoker fireChannelActive();

    /**
     * A {@link Channel} is inactive now, which means it is closed.
     *
     * This will result in having the  {@link ChannelInboundHandler#channelInactive(ChannelHandlerContext)} method
     * called of the next  {@link ChannelInboundHandler} contained in the  {@link ChannelPipeline} of the
     * {@link Channel}.
     * 一个通道现在是不活动的，这意味着它是关闭的。
     * 这将导致在Channel的ChannelPipeline中包含的下一个ChannelInboundHandler的channelInactive(ChannelHandlerContext)方法被调用。
     */
    ChannelInboundInvoker fireChannelInactive();

    /**
     * A {@link Channel} received an {@link Throwable} in one of its inbound operations.
     *
     * This will result in having the  {@link ChannelInboundHandler#exceptionCaught(ChannelHandlerContext, Throwable)}
     * method  called of the next  {@link ChannelInboundHandler} contained in the  {@link ChannelPipeline} of the
     * {@link Channel}.
     * 一个通道在它的inbound操作中接收到一个Throwable。
     * 这将导致在Channel的ChannelPipeline中包含的下一个ChannelInboundHandler的exceptionCaught(ChannelHandlerContext)方法被调用。
     */
    ChannelInboundInvoker fireExceptionCaught(Throwable cause);

    /**
     * A {@link Channel} received an user defined event.
     *
     * This will result in having the  {@link ChannelInboundHandler#userEventTriggered(ChannelHandlerContext, Object)}
     * method  called of the next  {@link ChannelInboundHandler} contained in the  {@link ChannelPipeline} of the
     * {@link Channel}.
     * 一个通道接收到一个用户定义的事件。
     * 这将导致在Channel的ChannelPipeline中包含的下一个ChannelInboundHandler的userEventTriggered(ChannelHandlerContext)方法被调用。
     */
    ChannelInboundInvoker fireUserEventTriggered(Object event);

    /**
     * A {@link Channel} received a message.
     *
     * This will result in having the {@link ChannelInboundHandler#channelRead(ChannelHandlerContext, Object)}
     * method  called of the next {@link ChannelInboundHandler} contained in the  {@link ChannelPipeline} of the
     * {@link Channel}.
     * 一个通道接收到一个message。
     * 这将导致在Channel的ChannelPipeline中包含的下一个ChannelInboundHandler的channelRead(ChannelHandlerContext)方法被调用。
     */
    ChannelInboundInvoker fireChannelRead(Object msg);

    /**
     * Triggers an {@link ChannelInboundHandler#channelReadComplete(ChannelHandlerContext)}
     * event to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * 触发channelReadComplete事件到ChannelPipeline中的下一个ChannelInboundHandler。
     */
    ChannelInboundInvoker fireChannelReadComplete();

    /**
     * Triggers an {@link ChannelInboundHandler#channelWritabilityChanged(ChannelHandlerContext)}
     * event to the next {@link ChannelInboundHandler} in the {@link ChannelPipeline}.
     * 触发channelWritabilityChanged事件到ChannelPipeline中的下一个ChannelInboundHandler。
     */
    ChannelInboundInvoker fireChannelWritabilityChanged();
}
