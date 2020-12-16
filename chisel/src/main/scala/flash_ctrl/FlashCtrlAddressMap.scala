// SPDX-FileCopyrightText: 2020 Muhammad Hadir Khan
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// SPDX-License-Identifier: Apache-2.0
package flash_ctrl
import chisel3._

object FlashCtrlAddressMap {
  val FLASH_CTRL_INTR_STATE_OFFSET = "h0".U(8.W)
  val FLASH_CTRL_INTR_ENABLE_OFFSET = "h4".U(8.W)
  val FLASH_CTRL_INTR_TEST_OFFSET = "h8".U(8.W)
  val FLASH_CTRL_CTRL_REGWEN_OFFSET = "hc".U(8.W)
  val FLASH_CTRL_CONTROL_OFFSET = "h10".U(8.W)
  val FLASH_CTRL_ADDR_OFFSET = "h14".U(8.W)
  val FLASH_CTRL_OP_STATUS_OFFSET = "h8c".U(8.W)
  val FLASH_CTRL_STATUS_OFFSET = "h90".U(8.W)
  val FLASH_CTRL_PHY_STATUS_OFFSET = "h94".U(8.W)
  val FLASH_CTRL_FIFO_RST_OFFSET = "ha0".U(8.W)
}
