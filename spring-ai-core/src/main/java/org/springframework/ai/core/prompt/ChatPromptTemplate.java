/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.ai.core.prompt;

import org.springframework.ai.core.prompt.messages.ChatMessage;
import org.springframework.ai.core.prompt.messages.MessageType;

import java.util.Map;

/**
 * A PromptTemplate that lets you specify the role as a string should the current
 * implementations and their roles not suffice for your needs.
 */
public class ChatPromptTemplate extends PromptTemplate {

	private MessageType messageType;

	public ChatPromptTemplate(MessageType messageType, String template) {
		super(template);
		this.messageType = messageType;
	}

	@Override
	public Prompt create() {
		return new Prompt(new ChatMessage(this.messageType, render()));
	}

	@Override
	public Prompt create(Map<String, Object> model) {
		return new Prompt(new ChatMessage(this.messageType, render(model)));
	}

}