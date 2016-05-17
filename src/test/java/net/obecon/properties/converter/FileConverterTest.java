/*
 * © Copyright 2016 Oberbaum Concept UG, Berlin, Germany - http://www.oberbaum-concept.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.obecon.properties.converter;

import java.io.File;

/**
 * @author Janne K. Olesen &lt;janne.olesen@oberbaum-concept.com&gt;
 */
public class FileConverterTest extends ConverterTestBase<File> {

	public FileConverterTest() {
		super(FileConverter.INSTANCE);
	}


	@Override
	protected Object[] fromStringParameters() {
		return new Object[]{
				createTestCase("test.txt", new File("test.txt")),
				createTestCase("file:" + File.separator + "test.txt", new File("file://test.txt")),
				createTestCase("file:" + File.separator + "test.txt", new File("file:\\test.txt")),
				createTestCaseFromStringException(null),
				createTestCaseFromStringException("")
		};
	}


	@Override
	protected Object[] toStringParameters() {
		File file1 = new File("text.txt");
		File file2 = new File("file:\\text.txt");
		File file3 = new File("file://text.txt");
		return new Object[]{
				createTestCase(file1.toString(), file1),
				createTestCase(file2.toString(), file2),
				createTestCase(file3.toString(), file3)
		};
	}
}